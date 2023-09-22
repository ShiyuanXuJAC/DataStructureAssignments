
import javax.swing.JFileChooser;

public class JFileChooserHelper {
  private static JFileChooser chooser;

  public static JFileChooser getChooser() {
    if (chooser == null) {
      chooser = new JFileChooser();
    }
    return chooser;
  }
}
