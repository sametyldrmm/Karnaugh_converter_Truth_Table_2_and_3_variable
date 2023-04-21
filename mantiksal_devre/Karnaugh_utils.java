package mantiksal_devre;

import java.util.Vector;

public class Karnaugh_utils extends File_utils {
    // private Vector<String> probability_table = new Vector<String>();
    private Vector<Vector<String>> probability_table = new Vector<Vector<String>>();
    private void find_probability_table()
    {
        for (int i = 0; i < Math.pow(2, variable_count); i++) {
            String temp = Integer.toBinaryString(i);
            while (temp.length() < variable_count) {
                temp = "0" + temp;
            }
            // probability_table.add(temp);
            Vector<String> temp2 = new Vector<String>();
            for (int j = 0; j < temp.length(); j++) {
                temp2.add(temp.substring(j, j+1));
            }
            probability_table.add(temp2);
        }
        // System.out.println(probability_table);

    }

    private void true_false_table()
    {
        // ilk önce tab ile boşluk bırakarak tüm variable_name leri yazdırıcaz
        System.out.println("Doğruluk tablosu:");
        for (int i = 0; i < variable_name.size(); i++) {
            System.out.print(variable_name.get(i) + "\t");
        }
        System.out.println("Sonuç");

        for (int i = 0; i < probability_table.size(); i++) {
            for (int j = 0; j < probability_table.get(i).size(); j++) {
                System.out.print(probability_table.get(i).get(j) + "\t");
            }

            Boolean temp = ((i / 4) > 1);
            Boolean temp2 = ((i / 4) % 2 == 0);

            int tek_ve_birden_büyükse = 0;
            if(temp)
            {
                tek_ve_birden_büyükse = (temp && temp2) ? +1 : 0;
                if (tek_ve_birden_büyükse == 0)
                    tek_ve_birden_büyükse = -1;
            }

            Boolean temp_y = (( i % 4) > 1);
            Boolean temp2_y = ((i % 4) % 2 == 0);

            int tek_ve_birden_büyükse_y = 0;
            if(temp_y)
            {
                tek_ve_birden_büyükse_y = (temp_y && temp2_y) ? +1 : 0;
                if (tek_ve_birden_büyükse_y == 0)
                    tek_ve_birden_büyükse_y = -1;
            }

            System.out.print(diagram_values.get(Integer.valueOf(i / 4) + tek_ve_birden_büyükse).get((i % 4) + tek_ve_birden_büyükse_y) );
            System.out.println();
        }

    }

    public Karnaugh_utils()
    {
        find_probability_table();

        true_false_table();
    }
}
