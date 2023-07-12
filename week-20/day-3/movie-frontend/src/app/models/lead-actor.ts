export class LeadActor {

    leadActorId: number;
    name: String;
    age: number;
    academyAwards: number;
    imageUrl: String;
    imdbUrl: String;

    constructor(leadActorId: number,
                name: String,
                age: number,
                academyAwards: number,
                imageUrl: String,
                imdbUrl: String) {
                    this.leadActorId = leadActorId;
                    this.name = name;
                    this.age = age;
                    this.academyAwards = academyAwards;
                    this.imageUrl = imageUrl;
                    this.imdbUrl = imdbUrl;
                }
}
