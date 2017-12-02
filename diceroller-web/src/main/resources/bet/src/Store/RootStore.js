import AppStore from './AppStore.js';
import DialogStore from './DialogStore.js';

export default class RootStore {
    constructor() {
        this.appStore = new AppStore(this);
        this.dialogStore = new DialogStore(this)
    }
}