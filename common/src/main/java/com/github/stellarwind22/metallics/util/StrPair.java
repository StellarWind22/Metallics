package com.github.stellarwind22.metallics.util;

public record StrPair(float Strength1, float Strength2) {

    public static StrPair of(float strength) {
        return new StrPair(strength, strength);
    }

    public StrPair mult(StrPair other) {
        return new StrPair(this.Strength1 * other.Strength1, this.Strength2 * other.Strength2);
    }

    public StrPair mult(float mult) {
        return new StrPair(this.Strength1 * mult, this.Strength2 * mult);
    }
}
