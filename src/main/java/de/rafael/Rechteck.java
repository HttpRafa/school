package de.rafael;

public class Rechteck {

    private float width;
    private float height;

    public Rechteck(float m_width, float m_height) {
        width = m_width;
        height = m_height;
    }

    public float umfang() {
        return (2 * width) + (2 * height);
    }

    public float fläche() {
        return width * height;
    }

}
