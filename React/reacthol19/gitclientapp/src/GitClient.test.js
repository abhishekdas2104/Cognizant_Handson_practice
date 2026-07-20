import axios from 'axios';
import GitClient from './GitClient';
jest.mock('axios');
describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const repos = [
      { name: 'appscentricsolutions' },
      { name: 'ArrayListDemo' },
      { name: 'ArrayListDemo01' }
    ];
    const resp = { data: repos };
    axios.get.mockResolvedValue(resp);
    const result = await GitClient.getRepositories('techiesyed');
    expect(result.data).toEqual(repos);
  });
});
