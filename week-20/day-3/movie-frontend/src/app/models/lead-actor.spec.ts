import { LeadActor } from './lead-actor';

describe('LeadActor', () => {
  it('should create an instance', () => {
    expect(new LeadActor(0, '', 0, 0, '', '')).toBeTruthy();
  });
});
