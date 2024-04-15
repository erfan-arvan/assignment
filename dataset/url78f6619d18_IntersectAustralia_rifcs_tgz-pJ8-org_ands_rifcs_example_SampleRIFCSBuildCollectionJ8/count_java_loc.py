import os

def count_lines_of_code(directory):
    total_lines = 0
    block_comment = False

    for root, dirs, files in os.walk(directory):
        for filename in files:
            if filename.endswith(".java"):
                file_path = os.path.join(root, filename)
                with open(file_path, 'r', encoding='utf-8') as file:
                    for line in file:
                        stripped_line = line.strip()
                        if block_comment:
                            if "*/" in stripped_line:
                                block_comment = False
                                # To consider code after the closing block comment on the same line:
                                index_closing = stripped_line.index("*/") + 2
                                if index_closing < len(stripped_line):
                                    total_lines += 1
                            continue
                        if "/*" in stripped_line:
                            block_comment = True
                            # Check if block comment ends on the same line it starts:
                            if "*/" in stripped_line:
                                block_comment = False
                                index_starting = stripped_line.index("/*")
                                index_closing = stripped_line.index("*/") + 2
                                # Count code before and after the comment if any:
                                if index_starting > 0:
                                    total_lines += 1
                                if index_closing < len(stripped_line):
                                    total_lines += 1
                                continue
                            # To consider code before the block comment starts on the same line:
                            if stripped_line.index("/*") > 0:
                                total_lines += 1
                            continue

                        if stripped_line != "" and not stripped_line.startswith("//"):
                            total_lines += 1
    return total_lines

current_directory = os.getcwd()
total_loc = count_lines_of_code(current_directory)
print(f"Total lines of code (excluding empty lines and comments): {total_loc}")

