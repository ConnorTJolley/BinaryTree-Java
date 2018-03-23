import java.util.Scanner;
class  BinaryNode
  {
  private int Key;
  private BinaryNode Left;
  private BinaryNode Right;

  public BinaryNode(int pKey)
    { // constructor 
   // Scanner user_input = new Scanner( System.in );
   // System.out.print("Enter in Key Value: ");
  //  Key =  user_input.nextInt();
    Key = pKey;
    Left = null;
    Right = null;
    }
     // Get Operations
  public int gKey()
    {
    return Key;
    }
  public BinaryNode gLeft()
    {
    return Left;
    }
  public BinaryNode gRight()
    {
    return Right;
    }
      //Set Operations
  public void sKey(int AValue)
    {
    Key = AValue;
    }
  public void sLeft( BinaryNode AValue)
    {
    Left = AValue;
    }
  public void sRight( BinaryNode AValue)
    {
    Right = AValue;
    }
} //End of node class code
