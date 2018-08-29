import { User } from './User';

export interface Issue {
    user: User;
    issueId: number;
    issueName: string;
    Priority: string;
}
