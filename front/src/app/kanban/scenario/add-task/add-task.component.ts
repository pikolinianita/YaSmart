import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TaskCreateDTO } from '../../../domain/creation/task-create-dto';

@Component({
  selector: 'app-add-task',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-task.component.html',
  styleUrl: './add-task.component.css'
})
export class AddTaskComponent {
  taskForm = new FormGroup({
    taskName: new FormControl(''),
    taskDescription: new FormControl('')
  });

  @Output() saveTask = new EventEmitter<TaskCreateDTO>();

createTask(): void {
  console.log(this.taskForm.value);
  let result = new TaskCreateDTO(this.taskForm.value.taskName!, this.taskForm.value.taskDescription!);
  this.saveTask.emit(result);
}

}
