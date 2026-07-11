import fs from 'fs';
import path from 'path';
import {parse} from 'csv-parse/sync';

export interface RegisterUser{
    type: string;
    firstname: string;
    lastname: string;
    email: string;
    telephone: string;
    password: string;
    confirmpassword: string;
}

export function registerData(): RegisterUser[]{
    const filepath = path.resolve(__dirname, "../TestData/RegisterData.csv");
    const filecontent = fs.readFileSync(filepath, 'utf-8');
    return parse(filecontent,{
        columns: true,
        skip_empty_lines: true,
        trim: true
    }) as RegisterUser[];
}