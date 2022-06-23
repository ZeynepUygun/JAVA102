import java.util.*;

public class Teams {
    List<String> teamList = new LinkedList<>();


    public void ligFixturePrint() {

        //If an odd number of team lists are entered, it adds another team named "Bay" team complete the even number.
        if (teamList.size() % 2 != 0) {
            teamList.add("Bay");
        }

//Prints the team list.
        if (teamList.size() != 0) {
            System.out.println("TAKIMLAR\n");
            for (String say : teamList) {
                System.out.println("-" + say);
            }


        } else {
            System.out.println("Kayitli takim bulunmamaktadir.");
        }
        System.out.println();
        round();

    }


    private void round() {

        List<String> teamListWeek = new LinkedList<>();


        int rount = 2 * (teamList.size() - 1);

//Adds the team list team the temporary list.

        List<String> teamListBacup = new LinkedList<>(teamList);


        int value = (teamList.size() / 2);


//the teams are paired away and away from home.

        for (int i = 1; i < rount / 2 + 1; i++) {

            for (int k = 0; k <= value + 2; k += 2) {
                teamListWeek.add(teamListBacup.get(k) + " " + teamListBacup.get(k + 1));
            }

/*the first item of the list is kept constant.the item in the middle of the list becomes the second item in the list. and
the last item is deleted from the list .The list scrolls to the right.*/

            teamListBacup.add(1, teamListBacup.get(value));
            teamListBacup.add(value, teamListBacup.get(teamListBacup.size() - 1));
            teamListBacup.remove(teamListBacup.size() - 1);
            teamListBacup.remove(teamListBacup.size() - 2);

        }

        //teams that have played away are written home. the teams that have played at home are away.

        for (int i = rount / 2 + 2; i <= rount + 1; i++) {
            for (int k = 0; k <= value + 2; k += 2) {
                teamListWeek.add(teamListBacup.get(k + 1) + " " + teamListBacup.get(k));
            }
/*the first item of the list is kept constant.the item in the middle of the list becomes the second item in the list. and
the last item is deleted from the list .The list scrolls to the right.*/

            teamListBacup.add(1, teamListBacup.get(value));
            teamListBacup.add(value, teamListBacup.get(teamListBacup.size() - 1));
            teamListBacup.remove(teamListBacup.size() - 1);
            teamListBacup.remove(teamListBacup.size() - 2);
        }

        int count = 0;
        int num;


//Prints teams by week.
        for (int i = 1; i <= rount; i++) {

            System.out.println("-----------------------------------\nRound " + i);

            List<String> bacup = new LinkedList<>();
            // he assigns matched Teams to the temporary list on a weekly basis.
            for (int n = count; n < count + value; n++) {

                bacup.add(teamListWeek.get(n));

            }
// It shuffles the ranks of the matched teams in the week. presses the screen.
            for (int m = 0; m < value; m++) {

                num = new Random().nextInt(bacup.size());
                System.out.println(bacup.get(num));
                bacup.remove(num);


            }


            count += value;

        }


    }


}
