import java.util.HashMap;
import java.util.Map;

public class NpcObserver implements Observer {

    private final Map<Class<? extends Subject>, Subject> subjects;
    private Npc npc;

    public NpcObserver(Npc npc) {
        this.npc = npc;
        this.subjects = new HashMap<>();
    }


    @Override
    public void update(Subject subject) {
        System.out.println("NpcObserver: " + npc.getName() + " is notified of " + subject.getClass().getSimpleName());
    }
}
