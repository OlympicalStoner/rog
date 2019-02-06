package events;

import com.megacrit.cardcrawl.events.AbstractImageEvent;

public class EventOrb extends AbstractImageEvent {
    public static final String ID = "rog:DiscoverOrb";

    public EventOrb(){
        super(ID, "My body text", "rogassets/img/events/placeholder.png");

        //This is where you would create your dialog options
        this.imageEventText.setDialogOption("My Dialog Option"); //This adds the option to a list of options
    }

    @Override
    protected void buttonEffect(int buttonPressed) {
        //It is best to look at examples of what to do here in the basegame event classes, but essentially when you click on a dialog option the index of the pressed button is passed here as buttonPressed.
    }
}
