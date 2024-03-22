import { TaskCreateDTO } from './task-create-dto';

describe('TaskCreateDTO', () => {
  it('should create an instance', () => {
    expect(new TaskCreateDTO("a", "b")).toBeTruthy();
  });
});
