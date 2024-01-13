import { Icon } from './icon';
import { Task } from './task';

describe('Task', () => {
  it('should create an instance', () => {
    expect(new Task("","",new Icon("",0,"",""),new Icon("",0,"",""))).toBeTruthy();
  });
});
