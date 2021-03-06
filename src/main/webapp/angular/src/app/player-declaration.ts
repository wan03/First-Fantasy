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

export class Action {
    constructor(
        public name: string,
        public user: number,
        public targets: TargetParams,
        public amount: number,
        public astat: number,
        public dstat: number,
        public tstat: number,
        public element: number,
        public focus: number,
        public uName: string
    ) {
        this.name = name;
        this.user = user;
        this.targets = targets;
        this.amount = amount;
        this.astat = astat;
        this.dstat = dstat;
        this.tstat = tstat;
        this.element = element;
        this.focus = focus;
        this.uName = uName;
    }
}

export class Stats {
    constructor(
        public hp: number,
        public atk: number,
        public def: number,
        public matk: number,
        public mdef: number,
        public spd: number,
        public acc: number,
        public evd: number,
        public crit: number,
        public chr: number,
        public dex: number
    ) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.matk = matk;
        this.mdef = mdef;
        this.spd = spd;
        this.acc = acc;
        this.evd = evd;
        this.crit = crit;
        this.chr = chr;
        this.dex = dex;
    }
}


export class Player {
    public id: number;
    public fid: number;
    public name: string;
    public stats: Stats; // this is a new class to create
    public action: Action;
    public party: string;
    public ready: boolean;
    public targets: number[];
    public alive: boolean
    constructor(
        idInput: number,
        fidInput: number,
        nameInput: string,
        statsInput: Stats, // this is a new class to create
        actionInput: Action,
        partyInput: string,
        readyInput: boolean,
        targetsInput: number[],
        aliveInput: boolean
    ) { 
        this.id = idInput;
        this.fid = fidInput;
        this.name = nameInput;
        this.stats = statsInput;
        this.action = actionInput;
        this.party = partyInput;
        this.ready = readyInput;
        this.targets = targetsInput;
        this.alive = aliveInput;
    }
}

// export class Player {
//     id: number;
//     fid: number;
//     name: string;
//     stats: Stats; // this is a new class to create
//     action: Action;
//     party: string;
//     ready: boolean;
//     targets: number[];
//     alive: boolean
//     constructor(p: Player) { 
//         this.id = p.id;
//         this.fid = p.fid;
//         this.name = p.name;
//         this.stats = p.stats;
//         this.action = p.action;
//         this.party = p.party;
//         this.ready = p.ready;
//         this.targets = p.targets;
//         this.alive = p.alive;
//     }
// }

export class Dto {
    constructor(
        public characters: Player[],
        public log: string,
        public status: number
    ) {
        this.characters = characters;
        this.log = log,
        this.status = status
    }
}

//{"id":0,"fid":0,"name":"Character",
//"stats":{"hp":0,"atk":0,"def":0,"matk":0,"mdef":0,"spd":0,"acc":0,"evd":0,"crit":0,"chr":0,"dex":0},
//"action":{"name":"Default","user":0,
//"targets":{"party":2,"self":1,"dead":0},
//"amount":0,"astat":1,"dstat":2,"tstat":0,"element":0,"focus":0,"uname":""},
//"party":"None","ready":false,"targets":[],"alive":false}

//From Java:     {"id":0,"fid":0,"name":"Character","stats":{"hp":0,"atk":0,"def":0,"matk":0,"mdef":0,"spd":0,"acc":0,"evd":0,"crit":0,"chr":0,"dex":0},"action":{"name":"Default","user":0,"targets":{"party":2,"self":1,"dead":0},"amount":0,"astat":1,"dstat":2,"tstat":0,"element":0,"focus":0,"uname":""},       "party":"None",  "ready":false,"targets":[], "alive":false}
//From Angular: [{"id":0,"fid":0,"name":"warrior",  "stats":{"hp":5,"atk":5,"def":5,"matk":5,"mdef":5,"spd":5,"acc":5,"evd":5,"crit":5,"chr":5,"dex":5},"action":{"name":"attack", "user":0,"targets":{"party":1,"self":1,"dead":0},"amount":0,"astat":1,"dstat":2,"tstat":0,"element":0,"focus":0,"uName":"warrior"},"party":"Heroes","ready":false,"targets":[1],"alive":true}]
// Create Stats.ts class to mirror Stats.java
// Now pass the Actor class into