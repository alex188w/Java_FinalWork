import java.util.Objects;

public class Notebook {
    int ramSize;
    int driveSize;
    String color;
    String osType;

    public Notebook(int ramSize, int driveSize, String osType, String color) {
        this.ramSize = ramSize;
        this.driveSize = driveSize;
        this.osType = osType;
        this.color = color;
    }

    @Override
    public String toString() {
        return (" ramSize \t" + ramSize + " ГБ \t" + " | driveSize \t" + driveSize + " ГБ " + " | osType \t" + osType
                + " | color \t" + color + "\t");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (getClass() != o.getClass())
            return false;
        Notebook notebook = (Notebook) o;
        return (ramSize >= notebook.ramSize) && (driveSize >= notebook.driveSize)
                && (notebook.osType == null || Objects.equals(osType, notebook.osType))
                && (notebook.color == null || Objects.equals(color, notebook.color));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ramSize, driveSize, osType, color);
    }

}
