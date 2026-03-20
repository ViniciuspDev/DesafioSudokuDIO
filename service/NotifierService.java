package service;

import static service.EventEnum.CLEAR_SPACE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifierService {

    private Map<EventEnum, List<EventListener>> listener = new HashMap<>() {
        {
            put(CLEAR_SPACE, new ArrayList<>());
        }
    };

    public void subscriber(final EventEnum eventType, EventListener listener) {
        var selectedListeners = ((Map<EventEnum, List<EventListener>>) listener).get(eventType);
        selectedListeners.add(listener);
    }

    public void notify(final EventEnum eventType) {
        listener.get(eventType).forEach(l -> l.update(eventType));

    }

}
