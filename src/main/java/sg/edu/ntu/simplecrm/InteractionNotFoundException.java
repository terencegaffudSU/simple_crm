package sg.edu.ntu.simplecrm;

public class InteractionNotFoundException extends RuntimeException  {
    InteractionNotFoundException(Long id) {
        super("Unable to find interactiong with id: "+ id + ",");
    }
}
