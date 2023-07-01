export interface Show {
    id: number
    name: string
    language: string
    genres: string
    status: string
    runtime?: number
    averageRuntime: number
    premiered: Date
    ended?: Date
    officialSite?: string
    rating: Number
    image: string
    summary: string
}
