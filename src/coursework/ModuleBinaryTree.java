/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author James
 */
public class ModuleBinaryTree implements IModuleBinaryTree {

    public ModuleBinaryTree left;
    public ModuleBinaryTree right;
    public Module node;
    public Module parent;
    int modulesInTree;
    HashSet<Module> moduleSet = new HashSet<>();

    public ModuleBinaryTree() {
        left = null;
        right = null;
        node = null;
        parent = null;
        modulesInTree = 0;
    }

    /*This function converts the ID into an int that is then used for 
    determining the placement within the tree*/
    public int IDtoInt(String id) {
        int value = 0;
        String ID = id.toLowerCase();
        for (int i = 0; i < ID.length(); i++) {
            value = value + (int) ID.charAt(i);
        }
        return value;
    }

    /*This function traverses all the noods within a tree when the root
    node is inputted.*/
    public Module traversal(Module root) {
        Module temp = root;
        if (temp != null) {
            if (temp.left != null) {
                traversal(temp.left.node);
            }
            if (temp.right != null) {
                traversal(temp.right.node);
            }
        }
        System.out.println("Module : " + temp.getModuleID());
        return temp;
    }

    /*This function is used when removing a module. It calculates the
    smallest value child node from the node inputted.*/
    public Module minValue(Module mod) {
        if (mod.left == null) {
            return mod;
        } else {
            return minValue(mod.left.node);
        }
    }

    @Override
    public void add(Module module) {
        int count = 0;
        if (node == null) {
            node = module;
            modulesInTree++;
            moduleSet.add(module);
            count++;
            System.out.println("Adding : " + module.getModuleID());
            System.out.println("Number of node visited : " + count);
        } else {
            if (parent == null) {
                parent = node;
            }
            int rootN = IDtoInt(parent.getModuleID());
            int newN = IDtoInt(module.getModuleID());
            if (rootN <= newN) {
                count++;
                if (parent.right == null) {
                    ModuleBinaryTree r = new ModuleBinaryTree();
                    parent.right = r;
                    r.node = module;
                    r.node.pNode = parent;
                    modulesInTree++;
                    moduleSet.add(module);
                    System.out.println("Adding : " + module.getModuleID());
                    System.out.println("Number of node visited : " + count);

                } else {
                    parent = parent.right.node;
                    add(module);
                    parent = null;
                }
            } else {
                if (parent.left == null) {
                    ModuleBinaryTree l = new ModuleBinaryTree();
                    parent.left = l;
                    l.node = module;
                    l.node.pNode = parent;
                    modulesInTree++;
                    moduleSet.add(module);
                    System.out.println("Adding : " + module.getModuleID());
                    System.out.println("Number of node visited : " + count);
                } else {
                    parent = parent.left.node;
                    add(module);
                    parent = null;
                }
            }
        }
    }

    @Override
    public void clear() {
        while (size() != 0) {
            Module mod = traversal(node);
            mod.right = null;
            mod.left = null;
            mod = null;
            modulesInTree--;
            moduleSet.clear();
        }
        node = null;
        System.out.println("Cleared");
    }

    @Override
    public Module getModule(String moduleID) {
        int count = 1;
        System.out.println("Getting module : " + moduleID);
        Module temp = node;
        int sID = IDtoInt(moduleID);
        int rID = IDtoInt(temp.getModuleID());
        String sName = moduleID;
        String rName = temp.getModuleID();
        while (!sName.equals(rName)) {
            count++;
            if ((sID < rID) && (!sName.equals(rName))) {
                if (temp.left == null) {
                    System.out.println("Module couldn't be found");
                    return null;
                } else {
                    temp = temp.left.node;
                    rID = IDtoInt(temp.getModuleID());
                    rName = temp.getModuleID();
                }
            } else if ((sID >= rID) && (!sName.equals(rName))) {
                if (temp.right == null) {
                    System.out.println("Module couldn't be found");
                    return null;
                } else {
                    temp = temp.right.node;
                    rID = IDtoInt(temp.getModuleID());
                    rName = temp.getModuleID();
                }
            } else if (count > modulesInTree) {
                System.out.println("Module couldn't be found");
                return null;
            }
        }
        System.out.println("Module found");
        System.out.println("Number of modules visited : " + count);
        return temp;
    }

    @Override
    public Collection<Module> getModules() {
        moduleSet.forEach((m) -> {
            if (m != null) {
                System.out.println(m.getModuleID() + " " + m.getModuleName());
            }
        });
        return moduleSet;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Module remove(String moduleID) {
        Module value;
        if (node == null) {
            return null;
        } else {
            value = getModule(moduleID);
            if (value.pNode == null) {
                if (value.right != null) {
                    Module min = minValue(value.right.node);
                    if (value.left != null) {
                        min.left = value.left;
                        min.left.node = value.left.node;
                    }
                    value = min;
                    modulesInTree--;
                    moduleSet.remove(value);
                }
            }
            System.out.println("Removing " + value.getModuleID());
            if ((value.left == null) && (value.right == null)) {
                System.out.println("Leaf node");
                if ((value.pNode.left != null) && (value.pNode.left.node == value)) {
                    value.pNode.left = null;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else if ((value.pNode.right != null) && (value.pNode.right.node == value)) {
                    value.pNode.right = null;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else {
                    System.out.println("ERROR HAS TWO PARENTS");
                }
            } else if ((value.left != null) && (value.right == null)) {
                System.out.println("Has left child");
                if ((value.pNode.left != null) && (value.pNode.left.node == value)) {
                    value.pNode.left = value.left;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else if ((value.pNode.right != null) && (value.pNode.right.node == value)) {
                    value.pNode.right = value.left;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else {
                    System.out.println("ERROR HAS TWO PARENTS");
                }
            } else if ((value.left == null) && (value.right != null)) {
                System.out.println("Has right child");
                if ((value.pNode.left != null) && (value.pNode.left.node == value)) {
                    value.pNode.left = value.right;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else if ((value.pNode.right != null) && (value.pNode.right.node == value)) {
                    value.pNode.right = value.right;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else {
                    System.out.println("ERROR HAS TWO PARENTS");
                }
            } else if ((value.left != null) && (value.right != null)) {
                System.out.println("Has left and right child");
                if ((value.pNode.left != null) && (value.pNode.left.node == value)) {
                    Module min = minValue(value.right.node);
                    min.left = value.left;
                    min.left.node = value.left.node;
                    value.pNode.left.node = min;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else if ((value.pNode.right != null) && (value.pNode.right.node == value)) {
                    Module min = minValue(value.right.node);
                    min.left = value.left;
                    min.left.node = value.left.node;
                    value.pNode.right.node = min;
                    modulesInTree--;
                    moduleSet.remove(value);
                } else {
                    System.out.println("ERROR HAS TWO PARENTS");
                }
            }
            return value;
        }
    }

    @Override
    public int size() {
        return modulesInTree;
    }
}
