import { EventEmitter } from 'events';

import dispatcher from '../dispatchers/Dispatcher.jsx';

class FlightsStore extends EventEmitter {
    constructor() {
        super();
        this.flights = '';
    }

    getAllFlights() {
        return this.flights;
    }

    handleAction(action) {
        console.log('Handling receive action..', action);
        switch (action.type)  {
            case "RECEIVE_FLIGHTS" :
            {
                this.flights = action.flights;
                this.emit("change");
                break;
            }
        }
    }
}

const flightStore = new FlightsStore;

dispatcher.register(flightStore.handleAction.bind(flightStore));

export default flightStore;