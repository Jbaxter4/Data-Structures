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
public class Module implements IModule {
    
    public String id;
    public String name;
    public Module pNode;
    public ModuleBinaryTree left;
    public ModuleBinaryTree right;
    
    Module(String i, String n){
        id = i;
        name = n;
        pNode = null;
    }

    @Override
    public String getModuleID() {
        return id;
    }

    @Override
    public String getModuleName() {
        return name;
    }
    
}
