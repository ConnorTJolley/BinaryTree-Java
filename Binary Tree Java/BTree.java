import java.util.Random;
public class BTree
    {
    private BinaryNode Root;
    private int NoOfNodes;

    private BTree()
      {                                      // constructor
      Root = null;
      NoOfNodes = 0;
     }
      public boolean IsEmpty()
      {
          return(NoOfNodes == 0);
      }
      public BinaryNode gRoot()
      {
          return Root;
      }
       public int Count()
      {
          return NoOfNodes;
      }
       public int Size(BinaryNode ATree)
      {
          if (ATree == null)
          {
            return 0;
          }
          else
          {
            return(1 + Size(ATree.gLeft()) + Size(ATree.gRight()));
          }
      }
        public int Height(BinaryNode ATree)
      {
          if (ATree == null)
          {
              return 0;
          } 
          else
          {
            return (1 + Math.max(Height(ATree.gLeft()), Height(ATree.gRight())));
          }
      }
       public void PreOrder(BinaryNode ATree)
      {
          if (ATree != null)
            {
            System.out.println(ATree.gKey());
            PreOrder(ATree.gLeft());
            PreOrder(ATree.gRight());
            }
      }

    public void InOrder(BinaryNode ATree)
      {
          if (ATree != null)
            {
            InOrder(ATree.gLeft());
            System.out.println(ATree.gKey());
            InOrder(ATree.gRight());
            }
      }

public void PostOrder(BinaryNode ATree)
      {
          if (ATree != null)
            {
            PostOrder(ATree.gLeft());
            PostOrder(ATree.gRight());
            System.out.println(ATree.gKey());
            }
      }
      public void Insert(int AId)
      {
            BinaryNode Temp,Current,Parent;
            if(Root == null)//tree is empty
            {
                Temp = new BinaryNode(AId);
                Root = Temp;
                NoOfNodes++;
            }
            else//tree is not empty
            {
                Temp = new BinaryNode(AId);
                Current = Root;
                while(true)//never ending while loop
                {
                      Parent = Current;
                      if(AId < Current.gKey())
                      {//go left
                         Current = Current.gLeft();
                         if (Current == null)
                         {
                          Parent.sLeft(Temp);
                          NoOfNodes++;
                          return;//jump out of loop
                         }
                      }
                      else
                      { //go right
                        Current = Current.gRight();
                        if(Current == null)
                        {
                          Parent.sRight(Temp);
                          NoOfNodes++;
                          return;
                        }
                      }
                }
             }
    }
      public BinaryNode Find(int AKey)
      {
          BinaryNode Current = null;
          if(!IsEmpty())
            {
            Current = Root; //start search at top of tree
            while(Current.gKey() != AKey)
              {
              if(AKey < Current.gKey())
              {
                Current = Current.gLeft();
              }
              else
                Current = Current.gRight();
              if(Current == null)
                return null;
              }
            }
          return Current;
      }
        public static void main (String [] Args)
    { // Test code
    Random generator = new Random();
    BTree MyTree = new BTree();                // Create the binary tree
    BinaryNode NodeAt;                              // Create a binary tree node
   
    //MyTree.Insert(5000);
    MyTree.Insert(666);
    MyTree.Insert(1);
    MyTree.Insert(11);
    MyTree.Insert(22);
    MyTree.Insert(33);
    MyTree.Insert(44);
    MyTree.Insert(55);
    MyTree.Insert(87);
    MyTree.Insert(53);
    MyTree.Insert(66);
    /*for (int i = 0;i < 1000;i++)
    {
        int r = generator.nextInt(10000);
        MyTree.Insert(r);
    }*/
   System.out.println("In Order Traversal");
    MyTree.InOrder(MyTree.gRoot());         // Display the tree in order
     System.out.println("Pre Order Traversal");
    MyTree.PreOrder(MyTree.gRoot());
     System.out.println("Post Order Traversal");
    MyTree.PostOrder(MyTree.gRoot());
    NodeAt = MyTree.Find(22);

    if(NodeAt !=null)
    {
      System.out.println("Data in Node with Key 22 = " + NodeAt.gKey());
      System.out.println("The height of the tree is " + MyTree.Height(MyTree.gRoot()));
      System.out.println("The number of nodes is " + MyTree.Count());
      System.out.println("Press the return key to continue");
      System.exit(0);
    }//end of test code
}
  }// end of class code