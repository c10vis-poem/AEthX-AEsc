#!/usr/bin/env bash
# AEthX-AEsc on Jetson Orin (aarch64 Ubuntu / L4T): llama.cpp on CUDA + the aesc core CLI.
# Usage: ./install.sh /path/to/model.gguf
set -euo pipefail
MODEL=${1:?usage: install.sh /path/to/model.gguf}
PREFIX=${AESC_HOME:-$HOME/aesc}
mkdir -p "$PREFIX"

sudo apt-get update
sudo apt-get install -y git cmake build-essential openjdk-17-jre-headless unzip curl gh

# llama.cpp with the CUDA backend (Jetson ships CUDA in /usr/local/cuda)
export PATH=/usr/local/cuda/bin:$PATH
[ -d "$PREFIX/llama.cpp" ] || git clone --depth 1 https://github.com/ggml-org/llama.cpp "$PREFIX/llama.cpp"
cmake -S "$PREFIX/llama.cpp" -B "$PREFIX/llama.cpp/build" -DGGML_CUDA=ON -DCMAKE_BUILD_TYPE=Release
cmake --build "$PREFIX/llama.cpp/build" -j"$(nproc)" --target llama-server

# aesc core CLI: latest CI artifact from c10vis-poem/AEthX-AEsc (needs `gh auth login`)
RUN=$(gh run list -R c10vis-poem/AEthX-AEsc --workflow core.yml --branch main --status success --limit 1 --json databaseId -q '.[0].databaseId')
gh run download "$RUN" -R c10vis-poem/AEthX-AEsc -n aesc-core-linux -D "$PREFIX/core"
chmod +x "$PREFIX/core/bin/aesc"

cat > "$PREFIX/env" <<ENV
export AESC_LOCAL_ENDPOINT=http://127.0.0.1:8080/v1/chat/completions
export AESC_LOCAL_MODEL=$(basename "$MODEL")
export PATH=$PREFIX/core/bin:\$PATH
ENV
echo "Start the server:  $PREFIX/llama.cpp/build/bin/llama-server -m $MODEL -ngl 999 --port 8080"
echo "Then:              source $PREFIX/env && aesc 'hello'"
