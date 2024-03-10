package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import org.example.Model;
import java.io.IOException;

public class Implement {
    Map<Integer,Model>data=new HashMap<>();
    public void add_task(Model model){
        int id=model.getTask_id();
        if(data.containsKey(id)) {
            System.out.println("task id already exists\n Enter valid task id");
            Scanner sc = new Scanner(System.in);
            int new_id = sc.nextInt();
            model.setTask_id(new_id);
            data.put(new_id,model);
        }
        else {
            data.put(id,model);
        }
        System.out.println("task added Successfully");
    }
    public void veiw_task()
    {
        if(data.size() == 0){ System.out.println("No Task available");return;}
        for(Map.Entry<Integer,Model> entry : data.entrySet())
        {
            System.out.println("Id="+entry.getValue().getTask_id());
            System.out.println("Task Title="+entry.getValue().getTask_name());
            System.out.println("Task Description="+entry.getValue().getTask_description());
            System.out.println("Status="+(entry.getValue().getTask_status()==true ? "Completed" : "Not Completed"));
        }
    }
    public void update_task(int id){
        Model model = data.get(id);
        model.setTask_status(true);
        data.put(id, model);
        System.out.println("Task updated successfully");
    }
    public void delete_task(int id){
        data.remove(id);
        System.out.println("Task deleteded successfully");
    }

    public void export(){
        try{
            File file = new File("task.txt");
            BufferedWriter bf= new BufferedWriter(new FileWriter(file));
            for(Map.Entry<Integer,Model>mp: data.entrySet()){
                    bf.write("Task Id:"+mp.getValue().getTask_id()+
                            "\nTaskName:"+mp.getValue().getTask_name()+
                            "\nTaskdescription:"+mp.getValue().getTask_description()+
                            "\nTaskStatus:"+(mp.getValue().getTask_status()==true ? "Completed" : "Not Completed"));
                    bf.newLine();
            }
            bf.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
