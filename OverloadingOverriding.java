class Parent {
    public void display() {
        System.out.println("Parent's display method");
    }
    
    public void display(int num) {
        System.out.println("Parent's display method with parameter: " + num);
}
    public void show() {
        System.out.println("Parent's show method");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child's show method");
    }
    

    public void display(String message) {
        System.out.println("Child's display method with message: " + message);
    }
}

public class OverloadingOverriding {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();            
        child.display(10);          
        child.display("Hello");     
        
        Parent parent = new Parent();
        parent.show();           
        
        Child childObj = new Child();
        childObj.show();     
    }
}
