
export class Player {
    constructor(
        public fid: string,
        public name: string,
        public stats: number[],
        public action: Action,
        public party: string,
        public ready: boolean,
        public targets: number[]
    ) { }
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
    ) { }
}

export class TargetParams {
    constructor(
        public party: number,
        public self: number,
        public dead: number
    ) { }
}
