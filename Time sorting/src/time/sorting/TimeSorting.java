package time.sorting;
import java.util.ArrayList;
import java.util.Scanner;
public class TimeSorting {

    public static String Timeconverter(String Time) {
        String newTimer = "";
        String Timesplit[] = Time.split(" ");
        String Timesplit2[] = Time.split(":");
        if (Timesplit[1].equals("PM")) {
            newTimer = Integer.toString(Integer.parseInt(Timesplit2[0]) + 12);
            newTimer = newTimer + ":" + Timesplit2[1].substring(0, 2);
        } else {
            newTimer = Timesplit[0];
        }
        return newTimer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of data: ");
        int data = in.nextInt();
        String Date[] = new String[data];
        String Time[] = new String[data];
        String newTime[] = new String[data];
        for (int i = 1; i <= data; i++) {
            System.out.println("Date?(Format MM/DD/YY): ");//The format is MM/DD/YY
            Date[i - 1] = in.next();
            in.nextLine();
            System.out.println("Time?(Format HH:MM AM/PM): ");//The format is HH:MM AM/PM
            Time[i - 1] = in.nextLine().trim();            
        }
        for (int y = 0; y < data; y++) {
            newTime[y] = Timeconverter(Time[y]);
        }
        int D[][] = new int[data][3];
        int T[][] = new int[data][2];
        for (int j = 1; j <= data; j++) {
            for (int k = 1; k <= 3; k++) {
                String Dx[] = Date[j - 1].split("/");
                for (int l = 1; l <= 3; l++) {
                    D[j - 1][l - 1] = Integer.parseInt(Dx[l - 1]);
                }
            }
        }
        for (int m = 1; m <= data; m++) {
            for (int n = 1; n <= 2; n++) {
                String Tx[] = newTime[m - 1].split(":");
                for (int o = 1; o <= 2; o++) {
                    T[m - 1][o - 1] = Integer.parseInt(Tx[o - 1]);
                }
            }
        }

        int day[] = new int[data];
        int month[] = new int[data];
        int year[] = new int[data];
        int hours[] = new int[data];
        int minutes[] = new int[data];
        for (int p = 1; p <= data; p++) {
            month[p - 1] = D[p - 1][0];
            day[p - 1] = D[p - 1][1];
            year[p - 1] = D[p - 1][2];
            hours[p - 1] = T[p - 1][0];
            minutes[p - 1] = T[p - 1][1];
        }
        // Sorting starts here--    
        
        ArrayList X = new ArrayList();
        X.add(-1);
        X.add(-2);
        boolean Y;
        boolean Z;
        boolean A;
        for (int s = 1; s <= data; s++) {
            Y = true;
            Z = true;
            A = true;
            for (int q = 1; q <= data; q++) {
                Z = true;
                Y=true;
                for (int t = 0; t < X.size(); t++) {
                    if (q == (int) X.get(t)) {
                        Z = false;
                    }
                }
                if (Z) {
                    for (int r = 1; r <= data; r++) {
                        A= true;
                        for (int u = 0; u < X.size(); u++) {
                            if (r == (int) X.get(u)) {
                                A = false;
                            }
                        }
                        if(r==q){
                            A=false;
                        }
                            if (A) {
                                if (year[q - 1] > year[r - 1]) {
                                    Y = false;
                                    break;
                                } else if (year[q - 1] < year[r - 1]) {
                                    continue;
                                } else {
                                    if (month[q - 1] > month[r - 1]) {
                                        Y = false;
                                        break;
                                    } else if (month[q - 1] < month[r - 1]) {
                                        continue;
                                    } else {
                                        if (day[q - 1] > day[r - 1]) {
                                            Y = false;
                                            break;
                                        } else if (day[q - 1] < day[r - 1]) {
                                            continue;
                                        } else {
                                            if (hours[q - 1] > hours[r - 1]) {
                                                Y = false;
                                                break;
                                            } else if (hours[q - 1] < hours[r - 1]) {
                                                continue;
                                            } else {
                                                if (minutes[q - 1] > minutes[r - 1]) {
                                                    Y = false;
                                                    break;
                                                } else {
                                                    continue;
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                continue;
                            }
                            
                        }
                    
                    }
                else{
                    continue;
                }
                    if (Y) {
                        System.out.println(Date[q - 1] + " " + Time[q - 1]);
                        X.add(q);
                        break;
                    }
                }
            }

    }
}
