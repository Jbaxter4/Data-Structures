/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Student b = new Student("Ben", "101", "Comp Sci");
        Student j = new Student("James", "102", "Comp Sci");
        Student s = new Student("Steve", "103", "Maths");
        Student m = new Student("Mary", "104", "English");
        Student l = new Student("Lucy", "105", "Geography");
        Student e = new Student("Emma", "106", "Business");
        Student a = new Student("Alan", "107", "Economics");
        Student c = new Student("Chris", "108", "Biology");
        Student d = new Student("Debra", "109", "Physics");
        Student f = new Student("Fiona", "110", "History");

        //Adds students to array and displays info desired in the log
        StudentAssociativeArray x = new StudentAssociativeArray(11);
        //System.out.println("Array Capacity = " + x.arraySize);
        //System.out.println("----------");
        x.put(b);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(j);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(s);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(m);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(l);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(e);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(a);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(c);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(d);
        //System.out.println("Array size : " + x.size());
        //System.out.println("Load Factor : " + x.getLoadFactor());
        //System.out.println("----------");
        x.put(f);
        //System.out.println("Size of the array : " + x.size());
        //System.out.println("Is the array empty : " + x.isEmpty());        

        //For loop that iterates throught the array
        /*for(int i = 0; i < x.arraySize; i++){
            if(x.array[i] != null){           
                System.out.println(i + " " + x.array[i].getSurname());
            } else {
                System.out.println(i + " Empty");
            }
        }*/
        Module DS = new Module("U08223", "Data Structures");
        Module FOOP = new Module("U08026", "Further Object Orientated Programming");
        Module DM = new Module("U08606", "Discrete Mathematics");
        Module EM = new Module("U04520", "Engineering Mathematics");
        Module IEG = new Module("U21104", "Introduction to Environmental Geography");
        Module ISG = new Module("U21189", "Independent Study in Geography");
        Module AEL = new Module("U70033", "Analysing English Language");
        Module UC = new Module("U75100", "Understanding Communication");
        Module LIBT = new Module("P22108", "Law of International Business Transactions");
        Module ESB = new Module("P38088", "Environmentally Sustainable Business");
        Module QW = new Module("U08056", "Example");

        //Adds all modules to a single student
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("Empty : " + j.modules.isEmpty());
        j.addModule(DS);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(FOOP);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(DM);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(EM);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(IEG);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(ISG);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(AEL);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(UC);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(LIBT);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(ESB);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");
        j.addModule(QW);
        //System.out.println("Tree size : " + j.modules.size());
        //System.out.println("----------");

        //This was particularly helpful at visuallising the binary tree I was
        //creating. It adds all the modules to a single binary tree and then
        //accesses all of them via the root.
        /*
        ModuleBinaryTree y = new ModuleBinaryTree();
        System.out.println(y.IDtoInt(DS.getModuleID()));
        System.out.println("---------------------");
        System.out.println(y.IDtoInt(FOOP.getModuleID()));
        System.out.println(FOOP.getModuleID());
        System.out.println(DS.right.node.getModuleID());
        System.out.println("---------------------");        
        System.out.println(y.IDtoInt(DM.getModuleID()));
        System.out.println(DM.getModuleID());
        System.out.println(DS.right.node.right.node.getModuleID());
        System.out.println("---------------------");      
        System.out.println(y.IDtoInt(EM.getModuleID()));
        System.out.println(EM.getModuleID());
        System.out.println(DS.left.node.getModuleID());
        System.out.println("---------------------");
        System.out.println(y.IDtoInt(IEG.getModuleID()));
        System.out.println(IEG.getModuleID());
        System.out.println(DS.left.node.left.node.getModuleID());
        System.out.println("---------------------");
        System.out.println(y.IDtoInt(ISG.getModuleID()));
        System.out.println(ISG.getModuleID());
        System.out.println(DS.right.node.right.node.right.node.getModuleID());
        System.out.println("---------------------");
        System.out.println(y.IDtoInt(AEL.getModuleID()));
        System.out.println(AEL.getModuleID());
        System.out.println(DS.left.node.right.node.getModuleID());
        System.out.println("---------------------");
        System.out.println(y.IDtoInt(UC.getModuleID()));
        System.out.println(UC.getModuleID());
        System.out.println(DS.left.node.right.node.right.node.getModuleID());
        System.out.println("--------------------");
        System.out.println(y.IDtoInt(LIBT.getModuleID()));
        System.out.println(LIBT.getModuleID());
        System.out.println(DS.left.node.left.node.right.node.getModuleID());
        System.out.println("--------------------");
        System.out.println(y.IDtoInt(ESB.getModuleID()));
        System.out.println(ESB.getModuleID());
        System.out.println(DS.right.node.right.node.right.node.right.node.getModuleID());
        y.clear();
        System.out.println(y.isEmpty());
        System.out.println(y.node);
         */
    }
}
