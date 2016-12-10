
/**
 * This is the master class that runs the tests of the program. It enqueues a test expression (infix) to the Infix Queue and runs  that
 *  translate the expression to postfix form (postfix queue) and then evaluates the expression on the value stack.
 * @author (ben durao) 
 * @version (10/30/16)
 */
public class main
{
    public static void main(String[] args)
    {
        InfixQueue iq = new InfixQueue();
        PostfixQueue pq = new PostfixQueue();
        OperatorStack os = new OperatorStack();

        String infix = "5*3+(6-8/2)#";
        String postfix = "";
        String match = "53*682/-+";

        String token = "";

        // Queue the expression
        for(int j=0; j < infix.length(); j++)
        {
            iq.enqueue( Character.toString( infix.charAt(j) ) );
            System.out.println("Enqueued to IQ: " + Character.toString( infix.charAt(j) ));
        }
        // init the operator stack
        os.push("#");
        System.out.println("Pushed " + os.ontop() + " to stack.");

        token = iq.front();
        // dequeue tokens until it is #
        while(!(token.equals("#")))
        {
            token = iq.dequeue();
            System.out.println("\nDequeued " + token + " from IQ");
            // is token an operand? [+ enqueue the operand on postfix queue] 
            if(!token.equals("*") && !token.equals("/") && !token.equals("+") && !token.equals("-") && !token.equals("(") && !token.equals(")") && !token.equals("#"))
            {
                pq.enqueue(token);
                System.out.println("Enqueued " + token + " to PQ");
            }
            else if(token.equals("#"))
            {
                while(!os.ontop().equals("#"))
                {
                    if(os.ontop().equals("("))
                    {
                        os.pop();
                    }
                    else {
                        System.out.println("Enqueued " + os.ontop() + " on PQ");
                        pq.enqueue( os.pop() );
                    }
                }
            }
            else
            {
                if( token.equals(")") )
                {
                    String operator = os.ontop();
                    // pop entries from operator stack and enqueue them until matching left parenthesis
                    while( !operator.equals("(") )
                    {
                        // disregard the parenthesis when queueing to postfix
                        operator = os.pop();
                        System.out.println("Popped " + operator + " off the stack.");
                        if(!operator.equals( ")") && !operator.equals("(") )
                        {
                            pq.enqueue(operator);
                            System.out.println("Enqueued " + operator + " to the PQ");
                        }
                        if(!os.empty())
                            operator = os.ontop();
                    }
                }
                else
                {
                    // another operator
                    if(os.size() > 1)
                    {
                        String operator = os.ontop();
                        if(os.stackPriority(operator) >= iq.infixPriority(token) && !operator.equals("("))
                        {
                            operator = os.pop();
                            System.out.println("Popped " + operator + " off the stack.");
                            pq.enqueue(operator);
                            System.out.println("Enqueued " + operator + " to PQ");
                        }
                    }
                    os.push(token);
                    System.out.println("Pushed " + token + " to stack.");
                }
            }
        }
        System.out.println();
        
        // Evaluate PostFix Expression
        token =" ";
        OperatorStack value = new OperatorStack();
        value.push("#");
        while(!pq.empty())
        {
            token = pq.dequeue();
            postfix += token;
            if(token.equals("*"))
            {
                value.push( Integer.toString( ( Integer.parseInt(value.pop()) * Integer.parseInt(value.pop()) ) ) );
                System.out.println("Pushed on value: " + value.ontop());
            }
            else if(token.equals("/"))
            {
                int denom = Integer.parseInt(value.pop());
                int numerator = Integer.parseInt(value.pop());
                value.push( Integer.toString( numerator / denom ) );
                System.out.println("Pushed on value: " + value.ontop());
            }
            else if(token.equals("+"))
            {
                value.push( Integer.toString( ( Integer.parseInt(value.pop()) + Integer.parseInt(value.pop()) ) ) );
                System.out.println("Pushed on value: " + value.ontop());
            }
            else if(token.equals("-"))
            {
                int subtractor = Integer.parseInt(value.pop());
                int prime = Integer.parseInt(value.pop());
                value.push( Integer.toString( prime - subtractor ) );
                System.out.println("Pushed on value: " + value.ontop());
            }
            else
            {
                value.push(token);
                System.out.println("Pushed on value: " + value.ontop());
            }
        }
        System.out.println("\nPostfix Expression = " + value.pop());
        System.out.println("Postfix = " + postfix);
        System.out.println("It should look like this = " + match);

    }
}
