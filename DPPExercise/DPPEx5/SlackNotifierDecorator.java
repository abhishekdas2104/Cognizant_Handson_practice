package DPPEx5;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        super.send();
        System.out.println("Sending Slack Notification");
    }
}