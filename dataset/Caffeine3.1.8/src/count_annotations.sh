#!/bin/bash

# Count occurrences of @NonNull
count_non_null=$(grep -r --include="*.java" "NonNull" . | wc -l)

# Count occurrences of @Nullable
count_nullable=$(grep -r --include="*.java" "Nullable" . | wc -l)

# Count occurrences of @MonotonicNonNull
count_monotonic_non_null=$(grep -r --include="*.java" "MonotonicNonNull" . | wc -l)

# Print the results
echo "Occurrences of @NonNull: $count_non_null"
echo "Occurrences of @Nullable: $count_nullable"
echo "Occurrences of @MonotonicNonNull: $count_monotonic_non_null"

