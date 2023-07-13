import { LeadActress } from './lead-actress';

describe('LeadActress', () => {
  it('should create an instance', () => {
    expect(new LeadActress(0, '', 0, 0, '', '')).toBeTruthy();
  });
});
