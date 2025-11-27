#!/usr/bin/env python3
import os
import sys
import glob

def create_from_template(template_path, placeholder, replacements):
    try:
        with open(template_path, "r", encoding="utf-8") as f:
            template_content = f.read()
    except Exception as e:
        print(f"Error reading template file '{template_path}': {e}")
        return

    template_filename = os.path.basename(template_path)
    dir_path = os.path.dirname(template_path)

    for replacement in replacements:
        new_filename = template_filename.replace(placeholder, replacement)
        new_content = template_content.replace(placeholder, replacement)
        new_path = os.path.join(dir_path, new_filename)

        try:
            with open(new_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            print(f"[CREATED] {new_path}")
        except Exception as e:
            print(f"Error writing file '{new_path}': {e}")

def main():
    if len(sys.argv) < 5:
        print("Usage: python from_template.py <directory> <template_pattern> <placeholder> <replacement1> [<replacement2> ...]")
        print("Example: python from_template.py ./ '*placeholder*.json' placeholder white red blue")
        sys.exit(1)

    root_dir = sys.argv[1]
    template_pattern = sys.argv[2]
    placeholder = sys.argv[3]
    replacements = sys.argv[4:]

    # Create full glob path
    glob_path = os.path.join(root_dir, template_pattern)
    matched_files = glob.glob(glob_path)

    if not matched_files:
        print(f"No files matched the pattern: {glob_path}")
        sys.exit(1)

    for template_path in matched_files:
        create_from_template(template_path, placeholder, replacements)

if __name__ == "__main__":
    main()
