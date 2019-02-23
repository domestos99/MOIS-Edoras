import { Injectable } from '@angular/core'
import { ServiceBase } from './servicebase';

@Injectable()
export abstract class ServiceBaseCRUD extends ServiceBase
{

  public abstract getAll(): Promise<any>;

  public abstract getById(id: number): Promise<any>;

  public abstract delete(row): Promise<any>;

  public abstract update(row): Promise<any>;

  public abstract insert(row): Promise<any>;





}
