Assignment - 2 
Aadit Singla - 100906986 Pratham Patel - 100920625 Joao Pedro Minari Prates - 100903075

Q1. Do some investigation into the Swing framework and write a short paragraph describing the purpose of the Swing framework. Submit a class diagram of the components of Swing.

SWING is a Java-based framework for creating Graphical User Interfaces. The swing library contains a set of classes that provide GUI components and are defined in the javax.swing package and its sub-packages. Another thing to note is that Swing is platform-independent, meaning applications that implement it can run on various operating systems without needing much modification. It offers many components like menus, labels, buttons, sliders, text fields etc. SWING also has features like event handling and layout managers that help applications be more user friendly. It also supports advance features like drag and drop:
Here is a class diagram of the components of SWING, created in Draw.io:
![Swing UML](https://github.com/user-attachments/assets/d566e0a0-64c3-4281-98a5-e1005124968a)

All components in SWING are Jcomponents and these components can be added to windows like the JFrame which is essentially a normal window with things like buttons, decorations, etc., or the JDialog which is similar to JFrame, but doesn’t have a minimize or maximize buttons and is modal which means that it blocks out other components until they are closed.


Q2. Look through the example code in the GitHub repository and explain how this example implements the MVC pattern. How does it differ from the conventional MVC pattern described in the lectures?

In the MVC architecture, there are three separate components: the Model, View, and Controller. In this example, all three components are defined and serve the following purposes:

Model: The Model component contains the business logic and data layer of the application. In this case, the Model has two attributes—first name and last name—and provides getter and setter methods to access and modify them.

View: The View component handles the graphical user interface that the user interacts with. In this example, the GUI is built using the Swing framework, with components like JButton, JFrame, JLabel, and JTextField.

Controller: The Controller acts as the intermediary between the View and Model layers. It contains the initView method, which initializes the text fields in the View using data from the Model, and the initController method, which handles user actions such as button clicks.

The implementation of MVC in this example differs from the conventional MVC pattern in a few ways. The example follows a Swing-based MVC, where the separation between components is not as strict. The Controller directly references and manipulates both the Model and the View, leading to tighter coupling between them. In contrast, the conventional MVC pattern typically enforces greater abstraction and loose coupling, often through the use of interfaces or event listeners to separate responsibilities. This abstraction allows the Model and View to operate more independently, making the system easier to maintain and extend.
