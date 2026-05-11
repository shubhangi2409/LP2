import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        System.out.println(" ChatBot: Hello! Welcome to Customer Support.");
        System.out.println("Type 'exit' to end the chat.\n");

        while (true) {
            System.out.print("You: ");
            userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println(" ChatBot: Thank you! Have a great day ");
                break;
            }

            // Basic responses
            else if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println(" ChatBot: Hello! How can I help you?");
            }

            else if (userInput.contains("product")) {
                System.out.println(" ChatBot: We offer electronics, clothing, and accessories.");
            }

            else if (userInput.contains("price")) {
                System.out.println(" ChatBot: Prices vary depending on the product. Please specify the item.");
            }

            else if (userInput.contains("order")) {
                System.out.println(" ChatBot: You can place an order through our website.");
            }

            else if (userInput.contains("delivery")) {
                System.out.println(" ChatBot: Delivery usually takes 3-5 business days.");
            }

            else if (userInput.contains("refund")) {
                System.out.println(" ChatBot: Refunds are processed within 5-7 days.");
            }

            else if (userInput.contains("contact")) {
                System.out.println(" ChatBot: You can contact us at support@email.com.");
            }

            else {
                System.out.println(" ChatBot: Sorry, I didn't understand that. Can you rephrase?");
            }
        }

        sc.close();
    }
}
