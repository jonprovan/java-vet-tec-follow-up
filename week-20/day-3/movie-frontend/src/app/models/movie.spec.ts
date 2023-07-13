import { LeadActor } from './lead-actor';
import { LeadActress } from './lead-actress';
import { Movie } from './movie';

describe('Movie', () => {
  it('should create an instance', () => {
    expect(new Movie(0, '', '', 0, new LeadActor(0, '', 0, 0, '', ''), new LeadActress(0, '', 0, 0, '', ''), 0, '', '')).toBeTruthy();
  });
});
