export class Player {
    constructor(
        public fid: number,
        public name: string,
        public stats: number[],
        public action: Action,
        public party: string,
        public ready: boolean,
        public targets: number[]
    ) { 
        this.fid = fid;
        this.name = name;
        this.stats = stats;
        this.action = action;
        this.party = party;
        this.ready = ready;
        this.targets = targets;
    }
}

export class Action {
    constructor(
        public name: string,
        public user: number,
        public uName: string,
        public targets: TargetParams,
        public amount: number,
        public astat: number,
        public dstat: number,
        public tstat: number,
        public element: number,
        public focus: number
    ) {
        this.name = name;
        this.user = user;
        this.uName = uName;
        this.targets = targets;
        this.amount = amount;
        this.astat = astat;
        this.dstat = dstat;
        this.tstat = tstat;
        this.element = element;
        this.focus = focus;

    }
}

export class TargetParams {
    constructor(
        public party: number,
        public self: number,
        public dead: number
    ) {
        this.party = party;
        this.self = self;
        this.dead = dead;
    }
}