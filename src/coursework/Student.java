/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.util.Collection;

/**
 *
 * @author James
 */
public class Student implements IStudent {

    public String surname;
    public String id;
    public String course;
    public ModuleBinaryTree modules;

    Student(String s, String i, String c) {
        surname = s;
        id = i;
        course = c;
        modules = new ModuleBinaryTree();
    }

    //PART 2
    @Override
    public void addModule(Module module) {
        modules.add(module);
        modules.moduleSet.add(module);
    }

    @Override
    public String getCourse() {
        return course;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    //PART 2
    @Override
    public Collection<Module> getModules() {
        return modules.getModules();
    }

    @Override
    public String getStudentID() {
        return id;
    }

    //PART 2
    @Override
    public Module removeModule(String moduleID) {
        Module mod = modules.getModule(moduleID);
        modules.remove(moduleID);
        return mod;
    }

}
