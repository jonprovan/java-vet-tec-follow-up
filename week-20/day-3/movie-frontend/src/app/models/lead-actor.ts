export class LeadActor {

    leadActorId: number;
    name: string;
    age: number;
    academyAwards: number;
    imageUrl: string;
    imdbUrl: string;

    constructor(leadActorId: number,
                name: string,
                age: number,
                academyAwards: number,
                imageUrl: string,
                imdbUrl: string) {
                    this.leadActorId = leadActorId;
                    this.name = name;
                    this.age = age;
                    this.academyAwards = academyAwards;
                    this.imageUrl = imageUrl;
                    this.imdbUrl = imdbUrl;
                }
}
