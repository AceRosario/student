import javax.swing.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String input;

        input = JOptionPane.showInputDialog("Enter number of students: ");
        int studentAmount = Integer.parseInt(input);

        Student[] st = new Student[studentAmount];

        for (int i = 0; i < st.length; i++) {
            input = JOptionPane.showInputDialog("Enter student data separated by commas.");

            String delim = ",";
            String token;

            StringTokenizer stk = new StringTokenizer(input, delim);

            token = stk.nextToken().trim();
            int id = Integer.parseInt(token);

            String name = stk.nextToken().trim();

            token = stk.nextToken().trim();
            int studentExams = Integer.parseInt(token);
            double[] scores = new double[studentExams];

            for (int j = 0; j < studentExams; j++) {
                token = stk.nextToken().trim();
                scores[j] = Double.parseDouble(token);
            }

            st[i] = new Student(id, name, scores);
        }

        String outA = "", outB = "", outC = "", outD = "", outF = "";

        for (int k = 0; k < st.length; k++) {
            String grade = st[k].findGrade();

            if (grade.equalsIgnoreCase("A")) {
                outA += st[k].getId() + " " + st[k].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("B")) {
                outB += st[k].getId() + " " + st[k].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("C")) {
                outC += st[k].getId() + " " + st[k].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("D")) {
                outD += st[k].getId() + " " + st[k].getName() + " (" + grade + ")\n";
            } else {
                outF += st[k].getId() + " " + st[k].getName() + " (" + grade + ")\n";
            }
        }

        String outAll = outA + outB + outC + outD + outF;

        JOptionPane.showMessageDialog(null, outAll);
    }
}
