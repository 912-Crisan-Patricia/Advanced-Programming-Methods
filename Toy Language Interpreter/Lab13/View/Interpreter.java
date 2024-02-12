package View;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import Model.MyException;
import Model.PrgState;
import Model.ADTs.MyDictionary;
import Model.ADTs.MyHeap;
import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIHeap;
import Model.ADTs.MyIList;
import Model.ADTs.MyIStack;
import Model.ADTs.MyList;
import Model.ADTs.MyStack;
import Model.Expressions.ArithExp;
import Model.Expressions.ReadHeapExp;
import Model.Expressions.RelationExp;
import Model.Expressions.ValueExp;
import Model.Expressions.VarExp;
import Model.Statements.CompStmt;
import Model.Statements.IStmt;
import Model.Statements.ExpresionStmts.PrintStmt;
import Model.Statements.FileStmts.CloseRFileStmt;
import Model.Statements.FileStmts.OpenRFileStmt;
import Model.Statements.FileStmts.ReadFileStmt;
import Model.Statements.HeapStmts.NewHeapStmt;
import Model.Statements.HeapStmts.WriteHeapStmt;
import Model.Statements.LoopStmts.WhileStmt;
import Model.Statements.SelectionStmts.IfStmt;
import Model.Statements.ThreadStmts.ForkStmt;
import Model.Statements.VarStmts.AssignStmt;
import Model.Statements.VarStmts.VarDeclStmt;
import Model.Statements.OtherStmts.NopStmt;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Types.RefType;
import Model.Types.Type;
import Model.Types.StringType;
import Model.Values.BoolValue;
import Model.Values.IValue;
import Model.Values.IntValue;
import Model.Values.StringValue;

class Interpreter {
    public static void main(String[] args) {

        List<Command> commands = new ArrayList<>();
        commands.add(new ExitCommand("0", "exit"));
        boolean TCHK_Error = false;

        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));

        try {
            ex1.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap1 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk1 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot1 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl1 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl1 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg1 = new PrgState(stk1, heap1, symtbl1, ot1, filetbl1, ex1);
            commands.add(new RunExample("1", ex1.toString(), prg1, "ex1"));
        } catch (MyException e) {
            System.out.println("1");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp('+', new ValueExp(new IntValue(2)),
                                new ArithExp('*', new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(
                                        new AssignStmt("b",
                                                new ArithExp('+', new VarExp("a"), new ValueExp(new IntValue(1)))),
                                        new PrintStmt(new VarExp("b"))))));

        try {
            ex2.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap2 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk2 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot2 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl2 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl2 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg2 = new PrgState(stk2, heap2, symtbl2, ot2, filetbl2, ex2);
            commands.add(new RunExample("2", ex2.toString(), prg2, "ex2"));
        } catch (MyException e) {
            System.out.println("2");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(
                                        new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new IntValue(2))),
                                                new AssignStmt("v", new ValueExp(new IntValue(3)))),
                                        new PrintStmt(new VarExp("v"))))));

        try {
            ex3.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap3 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk3 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot3 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl3 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl3 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg3 = new PrgState(stk3, heap3, symtbl3, ot3, filetbl3, ex3);
            commands.add(new RunExample("3", ex3.toString(), prg3, "ex3"));
        } catch (MyException e) {
            System.out.println("3");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex4 = new CompStmt(new VarDeclStmt("varf", new StringType()),
                new CompStmt(new AssignStmt("varf", new ValueExp(new StringValue("test.in"))),
                        new CompStmt(new OpenRFileStmt(new VarExp("varf")),
                                new CompStmt(new VarDeclStmt("varc", new IntType()),
                                        new CompStmt(new ReadFileStmt(new VarExp("varf"), new VarExp("varc")),
                                                new CompStmt(new PrintStmt(new VarExp("varc")),
                                                        new CompStmt(
                                                                new ReadFileStmt(new VarExp("varf"),
                                                                        new VarExp("varc")),
                                                                new CompStmt(new PrintStmt(new VarExp("varc")),
                                                                        new CloseRFileStmt(new VarExp("varf"))))))))));

        try {
            ex4.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap4 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk4 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot4 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl4 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl4 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg4 = new PrgState(stk4, heap4, symtbl4, ot4, filetbl4, ex4);
            commands.add(new RunExample("4", ex4.toString(), prg4, "ex4"));
        } catch (MyException e) {
            System.out.println("4");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex5 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new VarDeclStmt("v", new IntType()),
                                new CompStmt(new AssignStmt("a", new ValueExp(new IntValue(2))),
                                        new CompStmt(new AssignStmt("b", new ValueExp(new IntValue(2))),
                                                new CompStmt(
                                                        new IfStmt(
                                                                new RelationExp("!=", new VarExp("a"), new VarExp("b")),
                                                                new AssignStmt("v", new ValueExp(new IntValue(2))),
                                                                new AssignStmt("v", new ValueExp(new IntValue(3)))),
                                                        new PrintStmt(new VarExp("v"))))))));

        try {
            ex5.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap5 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk5 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot5 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl5 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl5 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg5 = new PrgState(stk5, heap5, symtbl5, ot5, filetbl5, ex5);
            commands.add(new RunExample("5", ex5.toString(), prg5, "ex5"));
        } catch (MyException e) {
            System.out.println("5");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex6 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new NewHeapStmt("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new VarDeclStmt("a", new RefType(new RefType(new IntType()))),
                                new CompStmt(new NewHeapStmt("a", new VarExp("v")),
                                        new CompStmt(new NewHeapStmt("v", new ValueExp(new IntValue(30))),
                                                new CompStmt(new PrintStmt(new VarExp("v")),
                                                        new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("v"))),
                                                                new CompStmt(new PrintStmt(new VarExp("a")),
                                                                        new CompStmt(
                                                                                new PrintStmt(new ReadHeapExp(
                                                                                        new VarExp("a"))),
                                                                                new PrintStmt(new ReadHeapExp(
                                                                                        new ReadHeapExp(new VarExp(
                                                                                                "a")))))))))))));

        try {
            ex6.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap6 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk6 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot6 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl6 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl6 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg6 = new PrgState(stk6, heap6, symtbl6, ot6, filetbl6, ex6);
            commands.add(new RunExample("6", ex6.toString(), prg6, "ex6"));
        } catch (MyException e) {
            System.out.println("6");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex7 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new NewHeapStmt("v", new ValueExp(new IntValue(0))),
                        new CompStmt(new VarDeclStmt("a", new IntType()),
                                new CompStmt(new AssignStmt("a", new ValueExp(new IntValue(3))),
                                        new CompStmt(
                                                new WhileStmt(new RelationExp(">", new VarExp("a"),
                                                        new ValueExp(new IntValue(0)))),
                                                new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("v"))),
                                                        new CompStmt(
                                                                new AssignStmt("a",
                                                                        new ArithExp('-', new VarExp("a"),
                                                                                new ValueExp(new IntValue(1)))),
                                                                new PrintStmt(new VarExp("a")))))))));

        try {
            ex7.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap7 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk7 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot7 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl7 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl7 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg7 = new PrgState(stk7, heap7, symtbl7, ot7, filetbl7, ex7);
            commands.add(new RunExample("7", ex7.toString(), prg7, "ex7"));
        } catch (MyException e) {
            System.out.println("7");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

        IStmt ex8 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(10))),
                        new CompStmt(new VarDeclStmt("a", new RefType(new IntType())),
                                new CompStmt(new NewHeapStmt("a", new ValueExp(new IntValue(22))),
                                        new CompStmt(
                                                new ForkStmt(new CompStmt(
                                                        new WriteHeapStmt("a", new ValueExp(new IntValue(30))),
                                                        new CompStmt(
                                                                new AssignStmt("v", new ValueExp(new IntValue(32))),
                                                                new CompStmt(new PrintStmt(new VarExp("v")),
                                                                        new PrintStmt(
                                                                                new ReadHeapExp(new VarExp("a"))))))),
                                                new CompStmt(new PrintStmt(new VarExp("v")),
                                                        new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("a"))),
                                                                new NopStmt())))))));

        try {
            ex8.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap8 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk8 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot8 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl8 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl8 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg8 = new PrgState(stk8, heap8, symtbl8, ot8, filetbl8, ex8);
            commands.add(new RunExample("8", ex8.toString(), prg8, "ex8"));
        } catch (MyException e) {
            System.out.println("8");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }

       /* IStmt ex9 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new BoolValue(0))),
                        new PrintStmt(new VarExp("v"))));

        try {
            ex9.typecheck(new MyDictionary<String, Type>(new ConcurrentHashMap<String, Type>()));
            MyIHeap<Integer, IValue> heap9 = new MyHeap<Integer, IValue>(new HashMap<Integer, IValue>());
            MyIStack<IStmt> stk9 = new MyStack<IStmt>(new Stack<IStmt>());
            MyIList<IValue> ot9 = new MyList<IValue>(new ArrayList<IValue>());
            MyIDictionary<String, IValue> symtbl9 = new MyDictionary<String, IValue>(
                    new ConcurrentHashMap<String, IValue>());
            MyIDictionary<String, BufferedReader> filetbl9 = new MyDictionary<String, BufferedReader>(
                    new ConcurrentHashMap<String, BufferedReader>());
            PrgState prg9 = new PrgState(stk9, heap9, symtbl9, ot9, filetbl9, ex9);
            commands.add(new RunExample("9", ex1.toString(), prg9, "ex9"));
        } catch (MyException e) {
            System.out.println("9");
            System.out.println(e.getMessage());
            TCHK_Error = true;
        }*/

        TextMenu menu = new TextMenu();
        menu.addCommands(commands);
        if (TCHK_Error == true) {
            System.out.println("\n Typecheck error(s) occured, please check the console for more details.");
            System.out.println("Press Enter key to continue...");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }

        menu.show();
    }
}
