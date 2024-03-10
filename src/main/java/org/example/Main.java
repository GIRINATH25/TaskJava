package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Implement implement = new Implement();
        boolean loop=true;
        while(loop) {
            System.out.println("1.Add task\n2.Update task\n3.View task\n4.Delete task\n5.Sava and Load\n6.Exit");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter the taskid");
                    int taskid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the taskname:");
                    String taskname = sc.nextLine();
                    System.out.println("Enter the taskdescription:");
                    String taskdesc = sc.nextLine();
                    Model model = new Model(taskid, taskname, taskdesc, false);
                    implement.add_task(model);
                }
                break;
                case 2:
                {
                    System.out.println("Enter the taskid");
                    int id = sc.nextInt();
                    implement.update_task(id);
                }
                break;
                case 3:
                {
                    implement.veiw_task();
                }
                break;
                case 4:
                {
                    System.out.println("Enter the taskid");
                    int taskid = sc.nextInt();
                    implement.delete_task(taskid);
                }
                break;
                case 5:
                {
                    implement.export();
                }
                break;
                case 6:
                {
                    loop=false;
                }
                break;
                default:
                    break;

            }
        }
    }
}