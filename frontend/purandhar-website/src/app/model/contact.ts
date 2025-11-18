export class Contact {

    cName?: string;
    cEmail?: string;
    cMessage?: string;


    constructor(cName: string = '', CEmail: string = '', cMessage: string = '') {
        this.cName = cName;
        this.cEmail = CEmail;
        this.cMessage = cMessage;
    }
}
