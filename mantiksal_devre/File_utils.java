package mantiksal_devre;

import java.util.*;
import java.io.*;  // Import the File class

public class File_utils 
{
    private     String fileName = "mantiksal_devre/girdi.txt";
    private     Vector<String> file_content = new Vector<String>();
    protected   Vector<String> variable_name = new Vector<String>();
    protected   int variable_count;
    protected   Vector<Vector<Integer>> diagram_values = new Vector<Vector<Integer>>();

    public Integer get_variable_count()
    {
        return variable_count;
    }

    public void set_variable_count(Integer variable_count)
    {
        this.variable_count = variable_count;
    }

    public Vector<String> get_variable_name()
    {
        return variable_name;
    }

    public Vector<Vector<Integer>> get_diagram_values()
    {
        return diagram_values;
    }
    
    
    
    private void read()
    {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                file_content.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    private void find_variables_names()
    {
        String temp = file_content.get(0);
        temp = temp.substring(temp.indexOf(",")-1);
        temp = temp.replace("," ,"");
        String[] temp2 =  temp.split(" ");
        variable_count = temp2.length;
        for (int i = 0; i < temp2.length; i++) {
            variable_name.add(temp2[i]);
        }
        // System.out.println(variable_name);
    }

    private void find_diagram_values()
    {
        for (int i = 0; i < file_content.size(); i++) {
            if (file_content.get(i).equals("diyagram:")) {
                for (int j = i+1; j < file_content.size(); j++) {
                    String[] temp = file_content.get(j).split(" ");
                    Vector<Integer> temp2 = new Vector<Integer>();
                    for (int k = 0; k < temp.length; k++) {
                        temp2.add(Integer.parseInt(temp[k]));
                    }
                    diagram_values.add(temp2);
                }
            }
        }
        // System.out.println(diagram_values);
    }

    public File_utils()
    {
        read();
        find_variables_names();
        find_diagram_values();
    }
    
}
