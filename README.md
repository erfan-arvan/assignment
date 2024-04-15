# Whole Program Inference (WPI) Repository

This repository contains all the necessary scripts, files, and data for running Whole Program Inference (WPI). 

## Repository Link
[GitHub Repository](https://github.com/erfan-arvan/assignment)

## Configuration
Ensure to configure the parameters used in `root-dir/wpi/run_wpi.py` and `root-dir/wpi/wpi/wpi.sh` as needed. The setup has been tested and run on macOS.

## Benchmark Structure
To run WPI on all benchmarks, the benchmarks must be structured in a standard format as proposed by the developers of the NJR dataset. This structure should include directories for classes, source files (`src`), information (`info`), JAR files (`jarfiles`), and libraries (`lib`). The most critical directories are `src`, which contains all the `.java` files, and `lib`, which contains all necessary `.class` files.

## Compiler Compatibility
Before execution, ensure that the benchmarks can be compiled using `javac`, as required by the checker framework. Download and prepare the latest release of the checker framework from [GitHub Releases](https://github.com/typetools/checker-framework/releases/tag/checker-framework-3.42.0). 

## Checker Framework Setup
Copy the `checker` directory from the downloaded framework to reside within the root directory at `scripts/tools/checker-framework-3.34.0`.

## Execution Steps
The specific steps to run WPI are as follows:
 ```
cd wpi
python3 run_wpi.py
```

This script manages the WPI outer layer and logs the results produced by the tool.
3. After execution, the resulting `.ajava` files will be stored for each benchmark in the directory `root-dir/dataset/benchmark-directory/src/wpi-iterations`.
4. The results of running the checker before and after WPI inference can be found in `root-dir/wpi/checkerframework-3.34.0-results-WPI`.

## GitHub Repository
All needed scripts and files are available in the following GitHub repository, which you can download and set up according to the provided instructions:
[GitHub Repository](https://github.com/erfan-arvan/assignment)

