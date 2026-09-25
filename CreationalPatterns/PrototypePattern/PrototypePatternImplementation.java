import java.util.HashMap;

interface Template {
    Template clone();
}

class EmailTemplate implements Cloneable, Template {

    private String content;
    private String toAddress;

    public EmailTemplate(String content, String toAddress) {
        this.content = content;
        this.toAddress = toAddress;
    }

    public void send() {
        System.out.println(
            "Sending Email with content: "
            + this.content
            + " to "
            + this.toAddress
        );
    }

    @Override
    public EmailTemplate clone() {
        try {
            return (EmailTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class TemplateFactory {
    private static HashMap<String, Template> templateRegistry =
        new HashMap<>();

    static {
        templateRegistry.put(
            "Email",
            new EmailTemplate("Default Content", "default@email.com")
        );
    }

    public Template getTemplate(String type) {
        return templateRegistry.get(type).clone();
    }
}

public class PrototypePatternImplementation {
    public static void main(String[] args) {

        TemplateFactory factory = new TemplateFactory();

        Template email1 = factory.getTemplate("Email");
        Template email2 = factory.getTemplate("Email");

        System.out.println(email1 == email2); // false
    }
}