package main.backend.messages;

public class MotivationalMessage {
    private String quote = "One strives to succeed, but it is difficult when one is unable to think of a quote.";
    private String author = "Anon Programmer";
    
    public MotivationalMessage(String message) {
        
        if(message == "Invalid String." || message == "" || message == null) {
            return;
        }

        boolean inQuote = false;
        boolean inAuthor = false;

        StringBuilder a = new StringBuilder();
        StringBuilder q = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) == '"') {
                inQuote = !inQuote;
            }

            if(message.charAt(i) == '-') {
                inAuthor = !inAuthor;
            }

            if(inQuote) {
                q.append(message.charAt(i));
            } 

            if(inAuthor) {
                a.append(message.charAt(i));
            }
        }

        this.quote = q.toString().trim();
        this.author = a.toString().trim();   
    }

    public String getAuthor() {
        return this.author;
    }

    public String getQuote() {
        return this.quote;
    }
}
